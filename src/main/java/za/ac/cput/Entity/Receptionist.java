package za.ac.cput.Entity;
/* Receptionist.java
   Entity for the Receptionist(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Receptionist
{
    @Id
    @Column(name = "receptionist_id")
    private String receptionistID;
    @NotNull
    private String receptionistName;
    @NotNull
    private String receptionistPassword;
    @NotNull
    private long receptionistTelephoneNumber;
    protected Receptionist() {
    }

    private Receptionist(Builder builder)
    {
        this.receptionistID = builder.receptionistID;
        this.receptionistName = builder.receptionistName;
        this.receptionistPassword = builder.receptionistPassword;
        this.receptionistTelephoneNumber = builder.receptionistTelephoneNumber;
    }

    public String getReceptionistID()
    {
        return receptionistID;
    }

    public String getReceptionistName()
    {
        return receptionistName;
    }

    public String getReceptionistPassword()
    {
        return receptionistPassword;
    }

    public long getReceptionistTelephoneNumber()
    {
        return receptionistTelephoneNumber;
    }

    @Override
    public String toString()
    {
        return "Receptionist{" +
                "receptionistID=" + receptionistID +
                ", receptionistName='" + receptionistName + '\'' +
                ", receptionistPassword='" + receptionistPassword + '\'' +
                ", receptionistTelephoneNumber=" + receptionistTelephoneNumber +
                '}';
    }

    public static class Builder
    {
        private String receptionistID;
        private String receptionistName;
        private String receptionistPassword;
        private long receptionistTelephoneNumber;

        public Builder setReceptionistID(String receptionistID) {
            this.receptionistID = receptionistID;
            return this;
        }

        public Builder setReceptionistName(String receptionistName) {
            this.receptionistName = receptionistName;
            return this;
        }

        public Builder setReceptionistPassword(String receptionistPassword) {
            this.receptionistPassword = receptionistPassword;
            return this;
        }

        public Builder setReceptionistTelephoneNumber(long receptionistTelephoneNumber) {
            this.receptionistTelephoneNumber = receptionistTelephoneNumber;
            return this;
        }

        public Builder copy(Receptionist receptionist)
        {
            this.receptionistID = receptionist.receptionistID;
            this.receptionistName = receptionist.receptionistName;
            this.receptionistPassword = receptionist.receptionistPassword;
            this.receptionistTelephoneNumber = receptionist.receptionistTelephoneNumber;
            return this;
        }
        public Receptionist build()
        {
            return new Receptionist(this);
        }
    }
}
