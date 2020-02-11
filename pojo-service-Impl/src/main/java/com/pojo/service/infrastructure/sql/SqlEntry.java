package com.pojo.service.infrastructure.sql;
import org.springframework.security.crypto.codec.Base64;

import javax.xml.bind.DatatypeConverter;
import java.sql.*;
import java.io.*;
/**
 * Created by virmanv on 26/09/2016 October.
 */
public class SqlEntry {


        public static void main(String[] args) {
            try{
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con=DriverManager.getConnection(
//                        "jdbc:mysql://localhost/g4odb","root","Life@123");

//                PreparedStatement ps=con.prepareStatement("insert into g4odb.Image values(?,?)");
//                ps.setInt(1, 1);
//                FileInputStream fin=new FileInputStream("/Users/virmanv/Desktop/Project_Universal_Mario.png");
//                System.out.println(fin.available());
//                ps.setBinaryStream(2,fin,fin.available());
//                int i=ps.executeUpdate();
//                System.out.println(i+" records affected");
//                con.close();

                readBlob();

            }catch (Exception e) {e.printStackTrace();}
        }
    private static void readBlob() throws SQLException, ClassNotFoundException {
        System.out.println("readBlob");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost/g4odb","root","Life@123");
        Blob image = null;

        PreparedStatement ps=con.prepareStatement("SELECT Imagecol FROM g4odb.Image where number=1 ");

        ResultSet rset = ps.executeQuery();

        Blob blob = null;
        while (rset.next()) {

            blob = rset.getBlob("Imagecol");
            byte[] ba = blob.getBytes(1, (int)blob.length());
            byte[] img64 = Base64.encode(ba);
            System.out.println(img64);
            String photo64 = DatatypeConverter.printBase64Binary(img64);
            System.out.println(photo64);
//            writeBlobFile( blob.getBytes(1,
//                    (int) blob.length()));
        }

        ps.close();
        con.close();

    }
    public static void writeBlobFile(byte[] data) {
        try {
            FileOutputStream fos = new FileOutputStream("/Users/virmanv/Desktop/"+ "faltu.png");
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
