package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.HeartPrincipleAction;
import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientWinterPrincipleAction;
import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FollowerHeartClovette extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerHeartClovette.class.getSimpleName());
    private static final String IMG_NAME = "clovette_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = HEART;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    public FollowerHeartClovette() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 4;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int heartAmount = PowerUtils.GetPowerAmount(Heart.POWER_ID, p);
                int times = heartAmount / magicNumber;
                if (times > 0) {
                    for (int i = 0; i < times; i++) {
                        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, 1), 1));

                    }
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