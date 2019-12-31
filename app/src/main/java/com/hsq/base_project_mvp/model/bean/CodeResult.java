package com.hsq.base_project_mvp.model.bean;

/**
 * <pre>
 *     author : hsq
 *     e-mail : 905319761@qq.com
 *     time   : 2019/04/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class CodeResult extends ResponseResult {

    private BodyBean body;
    public BodyBean getBody() {
        return body;
    }
    public void setBody(BodyBean body) {
        this.body = body;
    }
    public static class BodyBean {
        /**
         * code : 231880
         */
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "code='" + code + '\'' +
                    '}';
        }
    }
}
