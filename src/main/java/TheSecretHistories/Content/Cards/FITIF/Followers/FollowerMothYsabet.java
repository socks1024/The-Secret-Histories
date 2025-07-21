package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FollowerMothYsabet extends AbstractFollower{
    public static final String ID = StringUtils.MakeID(FollowerMothYsabet.class.getSimpleName());
    private static final String IMG_NAME = "ysabet_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.POWER;
    public static CardTags PRINCIPLE_TAG = MOTH;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public FollowerMothYsabet() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 3;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(2);
    }
}