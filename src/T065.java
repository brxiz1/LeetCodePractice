/**
 * @author ZhangYihe
 * @since 2025/1/5
 **/
public class T065 {
}

class Solution65{
    public boolean isNumber(String s) {
        int l=s.length();
        State state=State.start;
        for(int i=0;i<=l&&state!=State.error&&state!=State.end;i++){
            state=stateChange(state,s,i);
        }
        return state==State.end;
    }

    public State stateChange(State lastState,String s,int index){
        //这里需要加入判断
        if(index>=s.length()){
            if(lastState==State.num||lastState==State.eNum||lastState==State.pNum||lastState==State.numPoint){
                return State.end;
            }else{
                return State.error;
            }

        }
        char check=s.charAt(index);

        switch(lastState){

            case State.start:{
                if(check=='+'||check=='-'){
                    lastState=State.ch;
                }else if(check>='0'&&check<='9'){
                    lastState=State.num;
                }else if(check=='.'){
                    lastState=State.onlyPoint;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.ch:{
                //逆天案例
                if(check=='-'||check=='+'&&s.charAt(index-1)!='+'){
                }else if(check>='0'&&check<='9'){
                    lastState=State.num;
                }else if(check=='.'){
                    lastState=State.onlyPoint;
                }else{
                    lastState=State.error;
                }
                break;
            }
            case State.num:{
                if(check>='0'&&check<='9'){
                }else if(check=='.'){
                    lastState=State.numPoint;
                }else if(check=='e'||check=='E'){
                    lastState=State.e;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.numPoint, State.pNum:{
                if(check>='0'&&check<='9'){
                    lastState=State.pNum;
                }else if(check=='e'||check=='E'){
                    lastState=State.e;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.onlyPoint:{
                if(check>='0'&&check<='9'){
                    lastState=State.pNum;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.e:{
                if(check=='+'||check=='-'){
                    lastState=State.ech;
                }else if(check>='0'&&check<='9'){
                    lastState=State.eNum;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.ech:{
                if(check>='0'&&check<='9'){
                    lastState=State.eNum;
                }else{
                    lastState=State.error;
                }
                break;
            }

            case State.eNum:{
                if(check>='0'&&check<='9'){

                }else{
                    lastState=State.error;
                }
                break;
            }

            default:
        }
        return lastState;
    }
}

enum State{
    start,
    ch,
    num,
    numPoint,
    onlyPoint,
    pNum,
    e,
    ech,
    eNum,
    end,
    error

}