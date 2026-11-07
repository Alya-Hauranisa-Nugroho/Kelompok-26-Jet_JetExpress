package model;

public class Admin {

    private int idUser;
    private String jobdesk;
    private User user;

    public Admin() {
    }

    public Admin(int idUser, String jobdesk) {
        this.idUser = idUser;
        this.jobdesk = jobdesk;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getJobdesk() { return jobdesk; }
    public void setJobdesk(String jobdesk) { this.jobdesk = jobdesk; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
