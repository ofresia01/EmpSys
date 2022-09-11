/*
    Java class defining response payload
 */
package com.ofresia01.emp_sys.data.payloads.response;

public class MsgResponse {
    private String message;

    //Constructor
    public MsgResponse(String message) {
        this.message = message;
    }

    // Mutator
    public void setMessage(String message) {
        this.message = message;
    }

    // Accessor
    public String getMessage() {
        return message;
    }
}