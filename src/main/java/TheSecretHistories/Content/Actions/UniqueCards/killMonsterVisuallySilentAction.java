package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class killMonsterVisuallySilentAction extends AbstractGameAction {
    public killMonsterVisuallySilentAction(AbstractCreature target) {
        this.target = target;
    }

    @Override
    public void update() {
        addToTop(new InstantKillAction(target));
        this.isDone = true;
    }


}
