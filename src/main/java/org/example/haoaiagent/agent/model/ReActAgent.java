package org.example.haoaiagent.agent.model;


public abstract class  ReActAgent extends BaseAgent{

    /**
     * 处理当前状态并决定下一步行动
     * @return
     */
    public abstract boolean think();

    /**
     * 执行决定的行动
     * @return
     */
    public abstract String act();

    @Override
    public String step(){
        try {
            // 先思考
            boolean shouldAct = think();
            if(!shouldAct){
                return "思考完成，无需行动";
            }
            // 再行动
            return act();
        }catch (Exception e){
            e.printStackTrace();
            return "步骤执行失败" + e.getMessage();
        }

    }
}
