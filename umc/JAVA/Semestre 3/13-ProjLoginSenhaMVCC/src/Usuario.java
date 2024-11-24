
public class Usuario {
    public String login;
    public int senha;
    
    public boolean validar (){
        return (this.login == null ? this.login == null : this.login.equals(this.login)) && this.senha == this.senha;
    }
}
