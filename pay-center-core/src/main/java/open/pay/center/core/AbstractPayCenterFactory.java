package open.pay.center.core;

import open.pay.center.core.pay.PayWayFactory;
import open.pay.center.core.pay.query.PayQuery;
import open.pay.center.core.pay.request.PayCoreQueryRequest;
import open.pay.center.core.pay.response.PayCoreQueryResponse;
import open.pay.center.core.pay.way.ProtocolPay;
import open.pay.center.core.pay.way.ScanPay;

/**
 * User: hyman
 * Date: 2017/4/20 0020
 * Time: 14:45
 * Email: qyuhy@qq.com
 */
public abstract class AbstractPayCenterFactory implements PayWayFactory, PayQuery {

    public ProtocolPay createProtocolPay() {
        return injectProtocolPay();
    }

    public ScanPay createScanPay(){
        return injectScanPay();
    }


    public PayCoreQueryResponse query(PayCoreQueryRequest request) {
        return doPayQuery(request);
    }

    /**
     * 子类实现具体的支付查询结果
     *
     * @param request
     * @return
     */
    protected abstract PayCoreQueryResponse doPayQuery(PayCoreQueryRequest request);

    /**
     * 子类注入实现
     *
     * @return
     */
    protected abstract ProtocolPay injectProtocolPay();

    /**
     * 子类注入扫码支付类
     * @return
     */
    protected abstract ScanPay injectScanPay();
}