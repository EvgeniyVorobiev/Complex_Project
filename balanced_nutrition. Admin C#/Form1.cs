using Npgsql;
using System.Data;
using System.Diagnostics.Metrics;

namespace Комплексный_проект._Админ
{
    public partial class Form1 : System.Windows.Forms.Form
    {
        List<Group_PM> groups = new List<Group_PM>();
        public Form1()
        {
            InitializeComponent();
            NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
            try
            {
                connection.Open();

                NpgsqlCommand command = new NpgsqlCommand("select cp.group_pm.id_group_pm, cp.group_pm.name, cp.user_cp.login," +
                        " cp.planned_menu.id_planned_menu from cp.user_cp" +
                        " join cp.planned_menu on cp.user_cp.id_user = cp.planned_menu.id_user" +
                        " join cp.group_pm on cp.group_pm.id_group_pm = cp.planned_menu.id_group_pm;", connection);
                int rows_changed = command.ExecuteNonQuery();
                NpgsqlDataReader reader = command.ExecuteReader();

                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        object id = reader.GetValue(0);
                        object group_name = reader.GetValue(1);
                        object user_login = reader.GetValue(2);
                        object id_menu = reader.GetValue(3);
                        groups.Add(new Group_PM { Id = Convert.ToInt32(id), Name = Convert.ToString(group_name),
                            Menu_ID = Convert.ToInt32(id_menu)});
                        dataGridView1.Rows.Add(id, group_name, user_login, id_menu);
                    }
                }
                connection.Close();
                connection.Open();
                NpgsqlCommand command2 = new NpgsqlCommand("select * from cp.group_pm;", connection);
                int rows_changed2 = command2.ExecuteNonQuery();
                NpgsqlDataReader reader2 = command2.ExecuteReader();
                if (reader2.HasRows)
                {
                    while (reader2.Read())
                    {
                        object id = reader2.GetValue(0);
                        object group_name = reader2.GetValue(1);
                        groups.Add(new Group_PM
                        {
                            Id = Convert.ToInt32(id),
                            Name = Convert.ToString(group_name)
                        });
                        dataGridView2.Rows.Add(id, group_name);
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private void searchButton_Click(object sender, EventArgs e)
        {
            NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
            dataGridView1.Rows.Clear();
            groups.Clear();
            if (searchTextBox.Text == "" || textBox1.Text == "")
            {
                try
                {
                    connection.Open();

                    NpgsqlCommand command = new NpgsqlCommand("select cp.group_pm.id_group_pm, cp.group_pm.name, cp.user_cp.login," +
                        " cp.planned_menu.id_planned_menu from cp.user_cp" +
                        " join cp.planned_menu on cp.user_cp.id_user = cp.planned_menu.id_user" +
                        " join cp.group_pm on cp.group_pm.id_group_pm = cp.planned_menu.id_group_pm;", connection);
                    int rows_changed = command.ExecuteNonQuery();
                    NpgsqlDataReader reader = command.ExecuteReader();

                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            object id = reader.GetValue(0);
                            object group_name = reader.GetValue(1);
                            object user_login = reader.GetValue(2);
                            object id_menu = reader.GetValue(3);
                            groups.Add(new Group_PM
                            {
                                Id = Convert.ToInt32(id),
                                Name = Convert.ToString(group_name),
                                Menu_ID = Convert.ToInt32(id_menu),

                            });
                            dataGridView1.Rows.Add(id, group_name, user_login, id_menu);
                        }
                    }

                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
            else
            {
                try
                {
                    connection.Open();

                    NpgsqlCommand command = new NpgsqlCommand("select cp.group_pm.id_group_pm, cp.group_pm.name, cp.user_cp.login," +
                        " cp.planned_menu.id_planned_menu from cp.user_cp" +
                        " join cp.planned_menu on cp.user_cp.id_user = cp.planned_menu.id_user" +
                        " join cp.group_pm on cp.group_pm.id_group_pm = cp.planned_menu.id_group_pm" +
                        " where cp.user_cp.login like '%" + textBox1.Text +"%'" +
                        " and cp.group_pm.name like '%"+ searchTextBox.Text+"%';", connection);
                    int rows_changed = command.ExecuteNonQuery();
                    NpgsqlDataReader reader = command.ExecuteReader();

                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            object id = reader.GetValue(0);
                            object group_name = reader.GetValue(1);
                            object user_login = reader.GetValue(2);
                            object id_menu = reader.GetValue(3);
                            groups.Add(new Group_PM
                            {
                                Id = Convert.ToInt32(id),
                                Name = Convert.ToString(group_name),
                                Menu_ID = Convert.ToInt32(id_menu)
                            });
                            dataGridView1.Rows.Add(id, group_name, user_login, id_menu);
                        }
                    }

                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
                
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox2.Text != "" && textBox3.Text != "")
            {
                try
                {
                    NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
                    connection.Open();
                    string sqlDataInsert = "insert into cp.group_pm (name, number_of_servings) values (@nameValue, @number_of_servings);";
                    NpgsqlCommand command = new NpgsqlCommand(sqlDataInsert, connection);
                    command.Parameters.AddWithValue("@nameValue", textBox2.Text);
                    command.Parameters.AddWithValue("@number_of_servings", Convert.ToInt32(textBox3.Text));
                    command.ExecuteNonQuery();
                    connection.Close();


                    textBox2.Text = "";
                    textBox3.Text = "";
                    searchTextBox.Text = "";
                    //dataGridView1.Rows.Clear();
                    dataGridView2.Rows.Clear();
                    groups.Clear();



                    connection.Open();
                    NpgsqlCommand command3 = new NpgsqlCommand("select * from cp.group_pm;", connection);
                    int rows_changed2 = command3.ExecuteNonQuery();
                    NpgsqlDataReader reader2 = command3.ExecuteReader();
                    if (reader2.HasRows)
                    {
                        while (reader2.Read())
                        {
                            object id = reader2.GetValue(0);
                            object group_name = reader2.GetValue(1);
                            groups.Add(new Group_PM
                            {
                                Id = Convert.ToInt32(id),
                                Name = Convert.ToString(group_name)
                            });
                            dataGridView2.Rows.Add(id, group_name);
                        }
                    }
                    connection.Close();
                    label7.ForeColor = Color.Green;
                    label7.Text = "Группа создана";
                }
                catch
                {
                    label7.ForeColor = Color.Red;
                    label7.Text = "Произошла ошибка при создании группы";
                }
            }
        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

                foreach (Group_PM group in groups)
                {
                    if (dataGridView2.CurrentCell.Value == Convert.ToString(group.Name))
                    {
                        GroupInfo groupInfo = new GroupInfo();
                        groupInfo.GroupLoad(group);
                        groupInfo.ShowDialog();
                    }
                }
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            dataGridView2.Rows.Clear();
            NpgsqlConnection connection = new NpgsqlConnection("Server=localhost;Username=postgres;Database=balancednutrition;Port=5432;SSLMode=disable");
            connection.Open();
            NpgsqlCommand command3 = new NpgsqlCommand("select * from cp.group_pm;", connection);
            NpgsqlDataReader reader2 = command3.ExecuteReader();
            if (reader2.HasRows)
            {
                while (reader2.Read())
                {
                    object id = reader2.GetValue(0);
                    object group_name = reader2.GetValue(1);
                    groups.Add(new Group_PM
                    {
                        Id = Convert.ToInt32(id),
                        Name = Convert.ToString(group_name)
                    });
                    dataGridView2.Rows.Add(id, group_name);
                }
            }
            connection.Close();

        }
    }
}