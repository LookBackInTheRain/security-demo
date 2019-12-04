import java.io.*;

/**
 * @author yuit
 * @date 2019/12/4 12:40
 **/
public class Main {

    public static void main(String[] args) throws IOException {


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String password = reader.readLine();
                int i;
                for (i =0;i<5;i++){
                    if (password.equals("123456")){
                        System.out.println("恭喜你进入游戏");
                        break;
                    }else if(i==4){
                        System.out.println("密码错误，游戏结束");
                        System.exit(0);
                    }else {
                        password = reader.readLine();
                    }



        }



    }

    /**
     * 字节流copy文件
     * @param source 源文件
     * @param target 目标文件
     * @throws IOException ex
     */
    public static void copyFileByte(String source,String target) throws IOException {

        FileInputStream in = new FileInputStream(source);

        File targetFile = new File(target);

        if (!targetFile.exists()){
            targetFile.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(target,true);
        byte[] buf = new byte[1024];
        int length;
        while ((length=in.read(buf))!=-1){
            out.write(buf,0,length);
        }

        in.close();
        out.close();
    }

    /**
     * 字符流copy文件
     * @param source 源文件
     * @param target 目标文件
     * @throws IOException ex
     */
    public static void copyFileChar(String source,String target) throws IOException {
        File targetFile = new File(target);
        if (!targetFile.exists()){
            targetFile.createNewFile();
        }
        FileReader fileReader = new FileReader(source);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(target,true);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String line=null;

        while ((line=reader.readLine())!=null){
            writer.write(line+"\n");
        }

        reader.close();
        fileReader.close();

        writer.close();
        fileWriter.close();


    }


}
