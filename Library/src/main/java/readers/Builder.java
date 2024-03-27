package readers;

import java.util.ArrayList;

public interface Builder {

    public static ArrayList<String> f_Names = new ArrayList<>();
    public static ArrayList<String> m_Names = new ArrayList<>();
    public static ArrayList<String> f_Sec_Names = new ArrayList<>();
    public static ArrayList<String> m_Sec_Names = new ArrayList<>();
    public static ArrayList<String> sec_f_Teah_Names = new ArrayList<>();
    public static ArrayList<String> sec_m_Teah_Names = new ArrayList<>();
    public static ArrayList<String> patronymic = new ArrayList<>(); //отчества

    abstract Builder createFullName();

    public Builder createReader();

}
