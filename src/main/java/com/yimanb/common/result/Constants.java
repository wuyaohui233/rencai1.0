package com.yimanb.common.result;

public class Constants {
    public static final String appid="wx32791663560d9ea7";
    public static final String secret="d95b414a94983975dfdc68e0bb8e77ba";
    public static final String mch_id="1632388788";
    public static final String paternerKey="c6091428885d59621768176088293d95";

    //public static final String DOMAIN_NAME="http://cs.yimanb.com/";
    public static final String DOMAIN_NAME="http://angetcs.yimanb.com/";
    public static final String CallBack_Url=DOMAIN_NAME+"authorization_success";

    public static final String RechargeAmountCallBack_Url=DOMAIN_NAME+"RechargeAmountCallback.do";

    public static final String Pay_CallBack_Url=DOMAIN_NAME+"PayCallback";

    public static final Integer SUCCESS_CODE=200;
    public static final Integer ERROR_CODE=300;
    public static final Integer ERROR_SameOrder=801;

    /*陪玩状态*/
    public static final Integer normal=1;//正常
    public static final Integer busy=2;//忙碌
    public static final Integer stoporder=3;//暂停接单
    public static final Integer banned=4;//封禁

    /*陪玩审核状态*/
    public static final Integer applying=1;//审核中
    public static final Integer nopass=2;//未通过
    public static final Integer pass=3;//已通过

    /*老板状态*/
    public static final Integer normal_boss=1;//正常
    public static final Integer banned_boss=2;//封禁

    /*陪玩账户变更明细*/
    public static final Integer change_recharge=1;//充值 老板
    public static final Integer change_cost=2;//消费 老板
    public static final Integer change_refund=3;//退款
    public static final Integer change_withdraw=4;//提现


    /*陪玩账户变更明细*/
    public static final Integer change_royalty_server=1;//服务费分成
    public static final Integer change_royalty_fare=2;//车费分成
    public static final Integer change_withdraw_server=3;//服务费提现
    public static final Integer change_withdraw_fare=4;//车费提现
    public static final Integer change_dashang=5;//打赏

    /*提现状态*/
    public static final Integer withdraw_unremit=1;//未打款
    public static final Integer withdraw_remit=2;//已打款
    public static final Integer withdraw_refuse=3;//已拒绝

    /*提现类型*/
    public static final Integer withdraw_fare=1;//车费
    public static final Integer withdraw_server=2;//服务费


    /*预约状态*/
    public static final  String NoPay ="NoPay";//用户未支付
    public static final  String IsPay="IsPay";//已支付
    public static final  String TimeOutNoPay="TimeOutNoPay";//已支付
    public static final  String Finished="Finished";//结束
    public static final  String BossCancel="BossCancel";//取消
    public static final  String RefundReview="RefundReview";//退款
    public static final  String SuccessfulRefund="SuccessfulRefund";//退款成功
    public static final  String RefundReject="RefundReject";//退款驳回


    /*七牛云*/

    public static final String IMAGE = "image";

    public static final String FILE = "file";

    /**
     * AccessKey
     */
    public static String accessKey;
    /**
     * SecretKey
     */
    public static String secretKey;
    /**
     * 图片存储空间名
     */
    public static String bucketPictureName;
    /**
     * 图片外链
     */
    public static String domainPicture;
    /**
     * 文件存储空间名
     */
    public static String bucketFileName;
    /**
     * 文件外链
     */
    public static String domainFile;

    public static Integer unread=1;
    public static Integer isread=2;

}
