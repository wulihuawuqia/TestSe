/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午8:46:15
* 创建作者：伍恰
* 文件名称：DynamicFields.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

class DynamicFieldsException extends Exception{
    
}
public class DynamicFields {
    private Object[][] fields;
    public DynamicFields(int initialSize){
        fields = new Object[initialSize][2];
        for(int i = 0; i< initialSize; i++){
            fields[i] = new Object[]{null,null};
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Object[] obj : fields){
            result.append(obj[0]);
            result.append(":");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }
    private int hasField(String id){
        for(int i = 0;i<fields.length; i++){
            if(id.equals(fields[i][0])){
                return i;
            }
        }
        return -1;
    }
    private int getFieldNumber(String id) throws NoSuchFieldException{
        int fieldNum = hasField(id);
        if(fieldNum == -1){
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }
    
    private int makeField(String id){
        for(int i = 0;i < fields.length; i++){
           if(fields[i][0] == null){
               fields[i][0] = id;
               return i;
           }
        }
        Object[][] temp = new Object[fields.length+1][2];
        for(int i = 0; i < fields.length; i++){
           temp[i] = fields[i];    
        }
        for(int i = fields.length; i < temp.length;i++){
            temp[i] = new Object[]{null,null};
        }
        fields = temp;
        return makeField(id);
    }
    
    public Object getField(String id) throws NoSuchFieldException{
        return fields[getFieldNumber(id)][1];
    }
    public Object setField(String id, Object value) throws DynamicFieldsException{
        if(value==null){
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if(fieldNumber == -1){
            fieldNumber = makeField(id);
        }
        Object result = null;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }
    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A value for d");
            df.setField("number3", 47);
            System.out.println(df);
            
            System.out.println(df.getField("d"));
            
            //System.out.println(df.setField("d", null)); java.lang.NullPointerException
            System.out.println(df.setField("d", "ADD"));
        } catch (DynamicFieldsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
