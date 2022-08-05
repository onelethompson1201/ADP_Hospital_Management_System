/* Administration.java
   Entity for the administration(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Entity;

public class Administration 
{
    private String adminID;
    private String adminName;
    private String adminPassword;

    private Administration(Builder builder)
    {
        this.adminID = builder.adminID;
        this.adminName = builder.adminName;
        this.adminPassword = builder.adminPassword;
    }
    
    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Administration{" + "adminID=" + adminID + ", adminName=" + adminName + ", adminPassword=" + adminPassword + '}';
    }
    
    public static class Builder
    {
        private String adminID;
        private String adminName;
        private String adminPassword;

        public Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        public Builder setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }
        
        public Builder copy(Administration administration)
        {
            this.adminID = administration.adminID;
            this.adminName = administration.adminName;
            this.adminPassword = administration.adminPassword;
            
            return this;
        }
        
        public Administration build()
        {
            return new Administration(this);
        }
    }
}
