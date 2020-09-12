package cn.tedu.demo1.rui.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R{
    private Integer state;
    private String message;

    public static R ok(){
        return new R().setState(State.OK);
    }
    public static R not(Integer state,String message){
        return new R().setState(state).setMessage(message);
    }
    public static R not(Integer state,Throwable e){
        return not(state,e.getMessage());
    }

    public static interface State{
        int OK=2000;
        int ERR_PARAMETER_INVALIDATION = 4000;
        int ERR_NAME_NOT_NULL=4001;
        int ERR_INSERT=4002;

        int ERR_UNKNOWN=9999;
    }
}
