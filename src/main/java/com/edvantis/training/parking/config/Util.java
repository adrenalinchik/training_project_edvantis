package com.edvantis.training.parking.config;

import com.edvantis.training.parking.jdbc.AppProperty;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by taras.fihurnyak on 4/5/2017.
 */
public class Util {

    public static void importSQL(Connection conn, InputStream in) throws SQLException {
        Scanner s = new Scanner(in);
        s.useDelimiter("(;(\r)?\n)|(--\n)");
        Statement st = null;
        try {
            st = conn.createStatement();
            while (s.hasNext()) {
                String line = s.next();
                if (line.startsWith("/*!") && line.endsWith("*/")) {
                    int i = line.indexOf(' ');
                    line = line.substring(i + 1, line.length() - " */".length());
                }
                if (line.trim().length() > 0) {
                    st.execute(line);
                }
            }
        } finally {
            if (st != null) st.close();
        }
    }

    public static String getDatePattern(){
        return new AppProperty().getApplicationProperties().getProperty("date.template");
    }
}
