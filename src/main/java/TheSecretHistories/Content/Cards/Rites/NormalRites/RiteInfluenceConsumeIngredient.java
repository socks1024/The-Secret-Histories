package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Actions.UniqueCards.DiscardAnyAndDrawFullAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class RiteInfluenceConsumeIngredient extends AbstractNormalRite {

    public static final String ID = StringUtils.MakeID(RiteInfluenceConsumeIngredient.class.getSimpleName());

    private static final String IMG_NAME = "riteinfluenceconsumeingredient";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final ReducePrincipleInfo[] INFOS = new ReducePrincipleInfo[]{
        new ReducePrincipleInfo(LANTERN, 12),
        new ReducePrincipleInfo(EDGE, 8)
    };

    public RiteInfluenceConsumeIngredient() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBaseCost(0);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

        addToBot(new ConsumePrincipleAction(abstractPlayer, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {
                addToBot(new DiscardAnyAndDrawFullAction(abstractPlayer));
            }
        });
    }
}
