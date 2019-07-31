package com.tracktopell.learning;

import java.io.*;

public class CopyFilesByClasicWay {
    public static void main(String[] args) throws IOException {
        System.out.println( "Hello, CopyFilesByClasicWay:" );
        File inputDirecory =  new File("data/input");
        File outputDirecory =  new File("data/output");

        File inputFiles[] = inputDirecory.listFiles();
        for (File sourceFile:inputFiles) {
            if( sourceFile.isFile() ) {
                File destFile = new File( outputDirecory.getPath() +
                        File.separator +
                        sourceFile.getName());
                InputStream  fis = null;
                OutputStream fos = null;
                try {
                    System.out.println("\t--->> cp "+sourceFile+" "+destFile);
                    fos =  new FileOutputStream( destFile );
                    byte[] buffer=new byte[(int)sourceFile.length()];
                    fis = new FileInputStream(sourceFile);
                    fis.read(buffer);
                    fos.write(buffer);
                } catch(IOException ioe){
                    ioe.printStackTrace(System.err);
                } finally{
                    fis.close();
                    fos.close();
                }
            }
        }
    }
}
