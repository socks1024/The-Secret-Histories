package TheSecretHistories.Content.Cards.Rites.NormalRites;

import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Rites.AbstractNormalRite;
import TheSecretHistories.Content.Powers.UniqueCards.GainEnergyAtStartOfTurnPower;
import TheSecretHistories.Utils.PrincipleUtils.ReducePrincipleInfo;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class RiteToolConsumeIngredient extends AbstractNormalRite {

    public static final String ID = StringUtils.MakeID(RiteToolConsumeIngredient.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolconsumeingredient";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final ReducePrincipleInfo[] INFOS = new ReducePrincipleInfo[]{
            new ReducePrincipleInfo(MOTH, 12),
            new ReducePrincipleInfo(EDGE, 8)
    };

    public RiteToolConsumeIngredient() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

        addToBot(new ConsumePrincipleAction(abstractPlayer, INFOS) {
            @Override
            protected void OnConsumedEnough(int consumedAmount) {
                addToTop(new ApplyPowerAction(abstractPlayer, abstractPlayer, new GainEnergyAtStartOfTurnPower(abstractPlayer, magicNumber)));
            }
        });
    }
}
