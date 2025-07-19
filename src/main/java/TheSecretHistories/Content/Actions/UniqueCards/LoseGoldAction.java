package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;

public class LoseGoldAction extends AbstractGameAction {

    private int goldAmount;

    public LoseGoldAction(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    @Override
    public void update() {
        stealGold();

        isDone = true;
    }

    private void stealGold() {
        if (this.target.gold == 0)
            return;
        CardCrawlGame.sound.play("GOLD_JINGLE");
        if (this.target.gold < this.goldAmount)
            this.goldAmount = this.target.gold;
        this.target.gold -= this.goldAmount;
    }
}
