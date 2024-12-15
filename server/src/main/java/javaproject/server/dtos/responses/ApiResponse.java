    package javaproject.server.dtos.responses;

    import com.fasterxml.jackson.annotation.JsonInclude;
    import lombok.Builder;

    import java.util.Collection;

    @Builder
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public class ApiResponse<T> {
        private Integer status;
        private String  message;
        private Integer returnCode;
        private Integer count; // consist of null value
        private T       data;


        //Custom Constructor
        public ApiResponse(Integer status, String message, Integer returnCode, Integer count, T data) {
            this.status = status;
            this.message = message;
            this.returnCode = returnCode;
            this.data = data;

            //If data is a collection, return its size, else return null
            if(data instanceof Collection<?>)
            {
                this.count = ((Collection<?>) data).size();
            }
        }

        //Custom setData method
        public void setData(T data) {
            this.data = data;
            if(data instanceof Collection<?>)
            {
                this.count = ((Collection<?>) data).size();
            }
        }

        public Integer getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public Integer getReturnCode() {
            return returnCode;
        }

        public Integer getCount() {
            return count;
        }

        public T getData() {
            return data;
        }
    }
