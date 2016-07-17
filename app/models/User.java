package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

/**
 * Created by Iaron-PC on 17/07/2016.
 */
public class User {

    private UUID uuid;
    private Userpage userpage;
    private String email, username, password;

    public User(String email, String username, String password){
        this.uuid = UUID.randomUUID();
        this.userpage = new Userpage();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Userpage getUserpage(){
        return userpage;
    }

    // Maybe the fileContent will be a String later
    public void createFile(String filename, StringBuffer fileContent) throws Exception{
        File file = new File(filename + ".txt"); // we should create an enum later for the file types.
        writeInFile(file, fileContent);
        userpage.addFile(file);
    }

    private void writeInFile(File file, StringBuffer fileContent) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // This throws an exception.
        writer.write(fileContent.toString());
        writer.close();
    }

    public void createDIrectory(String directoryName) throws Exception{
        File directory = new File(directoryName);
        userpage.addDirectory(directory);
    }


}
