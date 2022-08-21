/* Administration.java
   Entity for the administration(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Administration implements Serializable
{
    @Id
    private String adminID;
    @NotNull
    private String adminName;
    @NotNull
    private String adminPassword;

    protected Administration(){}

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

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Administration administration = (Administration) obj;
        return adminID.equals(administration.adminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID);
    }
}


