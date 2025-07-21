package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WinterPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class FollowerWinterViolet extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerWinterViolet.class.getSimpleName());
    private static final String IMG_NAME = "violet_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = WINTER;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    public FollowerWinterViolet() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.exhaust = true;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int winterAmount = PowerUtils.GetPowerAmount(Winter.POWER_ID, p); // 假设你有这个 power ID
                if (winterAmount > 0) {
                    addToBot(new RemoveSpecificPowerAction(p, p, Winter.POWER_ID));

                    addToBot(new ApplyPowerAction(m, p, new Winter(m, winterAmount), winterAmount));
                }
                isDone=true;
            }
        });
    }
    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        this.exhaust = false;
    }
}
