package com.ngothanhtuan.managerstack.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MyPC on 12/17/2016.
 */

public class Project implements Parcelable {
    private String idPR, namePR, typePR,detailPR;

    protected Project(Parcel in) {
        idPR = in.readString();
        namePR = in.readString();
        typePR = in.readString();
        detailPR = in.readString();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public String getDetailPR() {
        return detailPR;
    }

    public void setDetailPR(String detailPR) {
        this.detailPR = detailPR;
    }

    public String getIdPR() {
        return idPR;
    }

    public void setIdPR(String idPR) {
        this.idPR = idPR;
    }

    public String getNamePR() {
        return namePR;
    }

    public void setNamePR(String namePR) {
        this.namePR = namePR;
    }

    public String getTypePR() {
        return typePR;
    }

    public void setTypePR(String typePR) {
        this.typePR = typePR;
    }

    public Project() {
    }

    public Project(String detailPR, String idPR, String namePR, String typePR) {
        this.detailPR = detailPR;
        this.idPR = idPR;
        this.namePR = namePR;
        this.typePR = typePR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idPR);
        dest.writeString(namePR);
        dest.writeString(typePR);
        dest.writeString(detailPR);
    }
}
