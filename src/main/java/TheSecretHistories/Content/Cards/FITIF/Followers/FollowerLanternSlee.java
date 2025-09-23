package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Actions.Principle.ConsumePrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FollowerLanternSlee extends AbstractFollower{
    public static final String ID = StringUtils.MakeID(FollowerLanternSlee.class.getSimpleName());
    private static final String IMG_NAME = "slee_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = LANTERN;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    public FollowerLanternSlee() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseBlock = this.block = 10;
        this.baseMagicNumber = this.magicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        addToBot(new GainBlockAction(p, p, this.block));
        addToBot(new DiscardAction(p, p, this.magicNumber, false));

    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeBlock(4);
    }

}