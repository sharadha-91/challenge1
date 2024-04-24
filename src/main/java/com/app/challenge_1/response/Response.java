package com.app.challenge_1.response;


public class Response {

       private ResponseStatus status;
       private String errorMessage;
       public Response(ResponseStatus status, String errorMessage) {
           this.status = status;
           this.errorMessage = errorMessage;
       }
       public static Response getFailureResponse(String errorMessage){
           System.out.println(" failure response : " + errorMessage);
           return new Response(ResponseStatus.FAILURE, errorMessage);
       }
       public static Response getSuccessResponse(){
           return new Response(ResponseStatus.SUCCESS, null);
       }

}
