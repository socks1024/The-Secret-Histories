package TheSecretHistories.Utils;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class LambdaUtils {

    public interface Lambda extends Runnable{}

    public static void AddToBottomLambda(Lambda func){
        AbstractDungeon.actionManager.addToBottom(
                new AbstractGameAction() {
                    @Override
                    public void update() {
                        func.run();
                        isDone = true;
                    }
                }
        );
    }

    public static void AddToTopLambda(Lambda func){
        AbstractDungeon.actionManager.addToBottom(
                new AbstractGameAction() {
                    @Override
                    public void update() {
                        func.run();
                        isDone = true;
                    }
                }
        );
    }
}
