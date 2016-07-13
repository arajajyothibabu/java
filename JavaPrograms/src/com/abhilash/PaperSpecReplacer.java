package com.abhilash;

import java.io.*;

/**
 * Created by Araja Jyothi Babu on 13-Jul-16.
 */
public class PaperSpecReplacer {

    private int[][] input = new int[2][12];
    private String filePath = ""; //absolute file path
    private String tempFile = "tempFile.txt";

    public PaperSpecReplacer(int[][] input, String filePath) {
        this.input = input;
        this.filePath = filePath;
    }

    public int[][] getInput() {
        return input;
    }

    public void setInput(int[][] input) {
        this.input = input;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private static String arrayToString(int [] array){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < array.length; i++){
            sb.append(String.valueOf(array[i]));
        }
        return sb.toString();
    }

    private static String modifyLine(String line, String content){
        int index = line.lastIndexOf(",");
        return line.replace(line.split(",")[line.split(",").length - 1], content);
    }

    public void replaceInFile() throws Exception{

        try {
            File file = new File(this.filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.tempFile)));
            String line, modifiedLine;
            while((line = reader.readLine()) != null) {
                if(line.contains("mstA4Sef")){
                    modifiedLine = modifyLine(line, arrayToString(this.input[0]));
                    writer.write(modifiedLine);
                }
                else if(line.contains("mstCustom")){
                    modifiedLine = modifyLine(line, arrayToString(this.input[1]));
                    writer.write(modifiedLine);
                }
                else writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            if(file.delete()){
                if(new File(this.tempFile).renameTo(file)){
                    System.out.print("File processed successfully..!");
                }
            }

        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}

class Tester{

    public static void main(String args[]) throws Exception{

        int array[][] = {{1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,0,0,0}};
        PaperSpecReplacer paperSpecReplacer = new PaperSpecReplacer(array, "A:\\GitHub\\Java Projects\\JavaPrograms\\src\\com\\abhilash\\tray.txt");
        paperSpecReplacer.replaceInFile();

    }

}
