package com.hsq.base_project_mvp.model.bean;

/**
 * <pre>
 *     author : hsq
 *     e-mail : 905319761@qq.com
 *     time   : 2019/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class ResponseResult {

    /**
     * respHead : {"respMsg":"请求成功","respCode":"0"}
     */
    private RespHeadBean respHead;

    public RespHeadBean getRespHead() {
        return respHead;
    }

    public void setRespHead(RespHeadBean respHead) {
        this.respHead = respHead;
    }

    public static class RespHeadBean {
        /**
         * respMsg : 请求成功
         * respCode : 0
         */

        private String respMsg;
        private String respCode;

        public String getRespMsg() {
            return respMsg;
        }

        public void setRespMsg(String respMsg) {
            this.respMsg = respMsg;
        }

        public String getRespCode() {
            return respCode;
        }

        public void setRespCode(String respCode) {
            this.respCode = respCode;
        }

        @Override
        public String toString() {
            return "RespHeadBean{" +
                    "respMsg='" + respMsg + '\'' +
                    ", respCode='" + respCode + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "ResponseResult{" +
                "respHead=" + respHead +
                '}';
    }
}
