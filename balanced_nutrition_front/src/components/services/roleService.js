import axios from "axios";

let arr = [];

class roleService {
    
    roleName = 'll';
    async fetchRole(){
        try {
            const response = await axios.get('http://localhost:8080/role/1');
            this.arr[0] = response.data;
            this.roleName = arr[0].name;
        } catch (error) {
            console.log(error);
        }
    }

    constructor(){
        // this.fetchRole();
        this.roleName="sad";
    }
}
export class role{
    id;
    name;
  }

roleService.fetchRole();
export default roleService;