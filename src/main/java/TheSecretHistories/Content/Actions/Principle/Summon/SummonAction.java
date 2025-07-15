package TheSecretHistories.Content.Actions.Principle.Summon;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SummonAction extends ConsumePrincipleAction {

    private final AbstractSpirit spirit;

    public SummonAction(PrincipleUtils.ReducePrincipleInfo[] infos, AbstractSpirit spirit) {
        super(AbstractDungeon.player, infos);
        this.spirit = spirit;
    }

    @Override
    protected void OnConsumedEnough(int consumedAmount) {
        addToTop(new MakeTempCardInHandAction(spirit.makeCopy()));
    }
}
