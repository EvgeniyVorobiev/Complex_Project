using Npgsql;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Комплексный_проект._Админ
{
    public partial class GroupInfo : Form
    {
        public Group_PM group_PM = new Group_PM() { };
        public void GroupLoad(Group_PM group)
        {
            group_PM = group;
            idTextBox.Text = group_PM.Id.ToString();
            nameTextBox.Text = group_PM.Name.ToString();
        }
        public GroupInfo()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                if (nameTextBox.Text != "")
                {
                    NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
                    connection.Open();
                    string sqlDataUpdate = "update cp.group_pm set name = '" + nameTextBox.Text + "' where id_group_pm = '" +
                        idTextBox.Text + "';";
                    NpgsqlCommand command = new NpgsqlCommand(sqlDataUpdate, connection);
                    command.ExecuteNonQuery();
                    connection.Close();
                    warningLabel.ForeColor = Color.Green;
                    warningLabel.Text = "Название группы изменено";
                }
            }
            catch 
            {
                warningLabel.ForeColor = Color.Red;
                warningLabel.Text = "Произошла ошибка при изменении";
            }
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            try
            {
                NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
                connection.Open();
                string sqlDataDelete = "delete from cp.group_pm where id_group_pm = '" + idTextBox.Text + "';";
                NpgsqlCommand command = new NpgsqlCommand(sqlDataDelete, connection);
                command.ExecuteNonQuery();
                connection.Close();
                warningLabel.ForeColor = Color.Green;
                warningLabel.Text = "Группа удалена";
            }
            catch
            {
                warningLabel.ForeColor = Color.Red;
                warningLabel.Text = "Произошла ошибка при удалении";
                
            }
        }
    }
}
