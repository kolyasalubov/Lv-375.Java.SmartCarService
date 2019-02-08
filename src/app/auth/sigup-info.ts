export class SignUpInfo {
    username: string;
    password: string;
    fullname: string;
    email: string;
    phoneNumber: string;
    role: string[];
    
 
    constructor(username: string, password: string, fullname: string, email: string, phoneNumber: string ) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = ['DIELER'];
    }
}