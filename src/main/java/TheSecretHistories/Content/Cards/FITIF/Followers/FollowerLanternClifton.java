package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientLartenPrincipleAction;
import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientWinterPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FollowerLanternClifton extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerLanternClifton.class.getSimpleName());
    private static final String IMG_NAME = "clifton_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = LANTERN;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerLanternClifton() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 4;

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new IngredientLartenPrincipleAction(m, p, PRINCIPLE_TAG, magicNumber, 1));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(-1);
    }

}