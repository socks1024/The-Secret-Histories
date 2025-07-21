package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FollowerLanternSlee extends AbstractFollower{
    public static final String ID = StringUtils.MakeID(FollowerLanternSlee.class.getSimpleName());
    private static final String IMG_NAME = "slee_a";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = LANTERN;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    public FollowerLanternSlee() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 3;
        this.exhaust = false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        int currentLantern = PowerUtils.GetPowerAmount(Lantern.POWER_ID, p);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                if (currentLantern >= magicNumber) {
                    addToBot(new ReducePowerAction(p, p, Lantern.POWER_ID, magicNumber));
                    addToBot(new DrawCardAction(p, 2));
                    magicNumber++;
                }
                isDone=true;
            }
        });

    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(-1);
    }

}
//*private static final CardTags PRINCIPLE_TAG = EDGE;
//
//    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());
//
//    private static final String IMG_NAME = "elridge";
//
//    private static final int COST = 1;
//
//    private static final CardType TYPE = CardType.ATTACK;
//
//    private static final CardRarity RARITY = CardRarity.COMMON;
//
//    private static final CardTarget TARGET = CardTarget.ENEMY;*/