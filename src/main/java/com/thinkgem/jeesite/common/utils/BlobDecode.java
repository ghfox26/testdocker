package com.thinkgem.jeesite.common.utils;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.log4j.Logger;

@MappedJdbcTypes(JdbcType.BLOB)
public class BlobDecode implements TypeHandler <Object> {  
    //###指定字符集  
    private static final String DEFAULT_CHARSET = "utf-8";  
    private static final Logger logger = Logger.getLogger(BlobDecode.class);
    /* (non-Javadoc)   
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)   
     */    
    @Override    
    public Object getResult(ResultSet arg0, String arg1) throws SQLException {    
    	String blob = (String) arg0.getString(arg1);  
        logger.info("ResultSet String blob:"+blob);
        byte[] returnValue = null;  
        if (null != blob) {  
            returnValue = Encodes.decodeBase64(blob);  
        }  
        try {  
            return new String(returnValue, DEFAULT_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }       
    }    
    @Override  
	public Object getResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
    	String blob = (String) arg0.getString(arg1);  
        logger.info("ResultSet int  blob:"+blob);
        byte[] returnValue = null;  
        if (null != blob) {  
            returnValue = Encodes.decodeBase64(blob);  
        }  
        try {  
            return new String(returnValue, DEFAULT_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }     
	}
      
    /* (non-Javadoc)   
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)   
     */    
    @Override    
    public Object getResult(CallableStatement arg0, int arg1)    
            throws SQLException {    
    	String blob = (String) arg0.getString(arg1);  
        logger.info("CallableStatement blob:"+blob);
        byte[] returnValue = null;  
        if (null != blob) {  
            returnValue = Encodes.decodeBase64(blob);  
        }  
        try {  
            return new String(returnValue, DEFAULT_CHARSET);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("Blob Encoding Error!");  
        }      
    }    
    
    /* (non-Javadoc)   
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)   
     */    
    @Override    
    public void setParameter(PreparedStatement arg0, int arg1, Object arg2,    
            JdbcType arg3) throws SQLException {    
    	String bis;  
    	String str="";
    	logger.info("arg2:"+arg2);
    	 if (null != arg2) { 
    		 str=arg2.toString();
    	 }
        
        //###把String转化成byte流  
		bis = Encodes.encodeBase64(str); 
		logger.info("bis:"+bis);     
        arg0.setString(arg1, bis);     
    }  
}
