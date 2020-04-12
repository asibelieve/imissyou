/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-31 22:45
 */
package com.github.wxpay.sdk;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LinWxPayConfigSample extends WXPayConfig {
    @Override
    public String getAppID() {
        return "wx4xxxxxxx";
    }
    @Override
    public String getMchID() {
        return "1589111117";
    }
    @Override
    public String getKey() {
        return "yDDDsDv6kFG1qXXX6jP";
    }
    @Override
    public InputStream getCertStream() {
        return null;
    }
    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }
    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
    @Override
    public IWXPayDomain getWXPayDomain(){
        IWXPayDomain  iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API,true);
            }
        };
        return iwxPayDomain;
    }

}
