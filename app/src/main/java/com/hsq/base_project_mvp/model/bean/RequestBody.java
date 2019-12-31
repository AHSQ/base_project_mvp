package com.hsq.base_project_mvp.model.bean;

import com.hsq.base_project_mvp.Constant;
import com.hsq.base_project_mvp.MyApplication;
import com.hsq.base_project_mvp.utils.AppUtil;

import java.util.HashMap;
import java.util.Map;

import static com.hsq.base_project_mvp.utils.AppUtil.getDate;
import static com.hsq.base_project_mvp.utils.AppUtil.getDeviceType;
import static com.hsq.base_project_mvp.utils.AppUtil.getImei;
import static com.hsq.base_project_mvp.utils.AppUtil.getNetType;
import static com.hsq.base_project_mvp.utils.AppUtil.getSysVersion;


public class RequestBody {

    /**
     * reqHead : {"functionId":"90001","version":"1.0","terminalName":"postmen","terminalId":"p00001","ip":"${ip}","terminalOs":"mac","net":"1","transTime":"201891515","terminalType":"PC"}
     * body : {"phone":"15797872498"}
     */

    private ReqHeadBean reqHead;
    private Map<String, Object> body = new HashMap<>();

    public Map<String, Object> getBody() {
        return body;
    }

    public RequestBody setBody(Map<String, Object> body) {
        this.body = body;
        return this;
    }

    public ReqHeadBean getReqHead() {
        return reqHead;
    }

    public RequestBody setReqHead(ReqHeadBean reqHead) {
        this.reqHead = reqHead;
        return this;
    }

    public static class ReqHeadBean {
        /**
         * functionId : 90001
         * version : 1.0
         * terminalName : postmen
         * terminalId : p00001
         * ip : ${ip}
         * terminalOs : mac
         * net : 1
         * transTime : 201891515
         * terminalType : PC
         */

        private String functionId;
//        private String version = Constant.VERSION;
        private String terminalName = getDeviceType();
        private String terminalId = getImei();
        private String ip = AppUtil.getIp(MyApplication.getContext());
        private String terminalOs = getSysVersion();
        private String net = String.valueOf(getNetType());
        private String transTime = getDate();
        private String terminalType = "mobile";

        public String getFunctionId() {
            return functionId;
        }

        public ReqHeadBean setFunctionId(String functionId) {
            this.functionId = functionId;
            return this;
        }

//        public String getVersion() {
//            return version;
//        }
//
//        public ReqHeadBean setVersion(String version) {
//            this.version = version;
//            return this;
//        }

        public String getTerminalName() {
            return terminalName;
        }

        public ReqHeadBean setTerminalName(String terminalName) {
            this.terminalName = terminalName;
            return this;
        }

        public String getTerminalId() {
            return terminalId;
        }

        public ReqHeadBean setTerminalId(String terminalId) {
            this.terminalId = terminalId;
            return this;
        }

        public String getIp() {
            return ip;
        }

        public ReqHeadBean setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public String getTerminalOs() {
            return terminalOs;
        }

        public ReqHeadBean setTerminalOs(String terminalOs) {
            this.terminalOs = terminalOs;
            return this;
        }

        public String getNet() {
            return net;
        }

        public ReqHeadBean setNet(String net) {
            this.net = net;
            return this;
        }

        public String getTransTime() {
            return transTime;
        }

        public ReqHeadBean setTransTime(String transTime) {
            this.transTime = transTime;
            return this;
        }

        public String getTerminalType() {
            return terminalType;
        }

        public ReqHeadBean setTerminalType(String terminalType) {
            this.terminalType = terminalType;
            return this;
        }
    }
}
