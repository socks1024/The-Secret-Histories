package TheSecretHistories.Content.Cards.FITIF.Tools.Knock;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class ToolKnockB extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolKnockB.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = KNOCK;

    private static final String IMG_NAME = "toolknockb";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolKnockB() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.baseBlock = this.block = 0;

        this.baseMagicNumber = this.magicNumber = 3;

        this.isEthereal = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(1);
        super.OnUpgrade(timesUpgraded);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);

        baseBlock = DeckUtils.GetMansusLevel();

        calculateDamageDisplay(m);

        for (int i = 0; i < this.magicNumber; i++) {

            addToBot(new GainBlockAction(p, p, block));

        }
    }

    @Override
    protected void PreApplyPowers() {
        baseBlock = DeckUtils.GetMansusLevel();
    }
}
