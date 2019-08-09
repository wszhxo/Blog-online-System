package cn.coderzhx.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author zhx
 * @create 2019-07-18-17
 * 上传图片到七牛云
 */
public class QiniuUpload {
        //设置好账号的ACCESS_KEY和SECRET_KEY
        private static String ACCESS_KEY = VariableName.accessKey; //这两个登录七牛 账号里面可以找到
        private static String SECRET_KEY = VariableName.secretKey;

        //要上传的空间
        private static String bucketname = VariableName.bucket; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

        //密钥配置
        private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        private static Configuration cfg = new Configuration(Zone.zone0());
        //创建上传对象

        private static UploadManager uploadManager = new UploadManager(cfg);

        //简单上传，使用默认策略，只需要设置上传的空间名就可以了
        public static String getUpToken(){
            return auth.uploadToken(bucketname);
        }

        public static String UploadPic(String FilePath,String FileName){
            UploadManager uploadManager = new UploadManager(cfg);
            String accessKey = VariableName.accessKey;      //AccessKey的值
            String secretKey = VariableName.secretKey;      //SecretKey的值
            String bucket = VariableName.bucket;                                          //存储空间名
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(FilePath, FileName, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                //System.out.println(putRet.key);
                //System.out.println(putRet.hash);
                System.out.println(VariableName.domain+"/"+FileName);
                return VariableName.domain+"/"+FileName;
            }catch (QiniuException ex){
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
            return null;
        }

    public static void main(String[] args) {
        UploadPic("blob:http://localhost:8080/e3b0eb77-4a34-4865-a113-78bafc619af8","222");
    }
}
