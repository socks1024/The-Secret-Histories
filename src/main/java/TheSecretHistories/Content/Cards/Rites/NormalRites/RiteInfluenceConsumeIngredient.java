package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Actions.UniqueCards.DiscardAnyAndDrawFullAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BarricadePower;

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
        this.baseBlock = this.block = 40;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
        upgradeBlock(20);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ConsumePrincipleAction(p, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {
                this.addToBot(new GainBlockAction(p, p, block));
                this.addToBot(new ApplyPowerAction(p, p, new BarricadePower(p)));
            }
        });
    }
}
