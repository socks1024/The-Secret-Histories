package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

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
