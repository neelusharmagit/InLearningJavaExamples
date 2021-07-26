import model.Student;

import java.io.*;

public class SerializingObject {


        public static void main(String args[]){
            try{
                //Creating the object
                Student s1 =new Student(1111,"SerializedName");
                //Creating stream and writing the object
                serializeObject(s1);


                deserialize();
            }catch(Exception e){System.out.println(e);}
        }



    private static void serializeObject(Student student) {
        try {
            FileOutputStream fout = new FileOutputStream("FileStudent.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(student);
            out.flush();
            //closing the stream
            out.close();
        } catch (FileNotFoundException fe) {
        } catch (IOException ie) {
        }
    }


    public static void deserialize(){
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("FileStudent.txt"));
            Student s=(Student)in.readObject();
            //printing the data of the serialized object
            System.out.println(s.id+" "+s.name);
            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}
