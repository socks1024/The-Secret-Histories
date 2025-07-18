package TheSecretHistories.Content.Actions.Principle;

import TheSecretHistories.Content.Powers.Principles.AbstractPrinciple;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ConsumePrincipleAction extends AbstractGameAction {

    private final ArrayList<ReducePrincipleInfo> infos = new ArrayList<>();

    public ConsumePrincipleAction(AbstractCreature source, AbstractCard.CardTags principleTag, int amount) {
        this.source = source;
        this.infos.add(new ReducePrincipleInfo(principleTag, amount));
    }

    public ConsumePrincipleAction(AbstractCreature source, ReducePrincipleInfo info) {
        this.source = source;
        this.infos.add(info);
    }

    public ConsumePrincipleAction(AbstractCreature source, ReducePrincipleInfo info1, ReducePrincipleInfo info2) {
        this.source = source;
        this.infos.add(info1);
        this.infos.add(info2);
    }

    public ConsumePrincipleAction(AbstractCreature source, ReducePrincipleInfo[] infos) {
        this.source = source;

        this.infos.addAll(Arrays.asList(infos));
    }

    public ConsumePrincipleAction(AbstractCreature source, AbstractCard.CardTags principleTag) {
        this(source, principleTag, -1);
    }

    @Override
    public void update() {

        int consumedAmount = 0;

        if (HasEnoughPrinciple()) {

            for (ReducePrincipleInfo info : infos) {

                if (!source.hasPower(info.principleID)) {
                    continue;
                }

                AbstractPrinciple p = (AbstractPrinciple) source.getPower(info.principleID);

                int a = info.reduceAmount;

                if (a < 0) a = PowerUtils.GetPowerAmount(info.principleID, source);

                p.reducePower(a);

                consumedAmount += a;

                if (p.amount <= 0) addToTop(new RemoveSpecificPowerAction(source, source, p));
            }

            OnConsumedEnough(consumedAmount);
        }

        isDone = true;
    }

    private boolean HasEnoughPrinciple() {

        boolean b = true;

        for (ReducePrincipleInfo info : infos) {
            if (PowerUtils.GetPowerAmount(info.principleID, source) < info.reduceAmount) {
                b = false;
            }
        }

        return b;
    }

    protected abstract void OnConsumedEnough(int consumedAmount);
}


