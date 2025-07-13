package TheSecretHistories.Content.Cards.FITIF.Tools.Knock;

import TheSecretHistories.Content.Actions.UniqueCards.RetainAllTaggedCardsAction;
import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.RITE;

public class ToolKnockD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolKnockD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = KNOCK;

    private static final String IMG_NAME = "toolknockd";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public ToolKnockD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new RetainAllTaggedCardsAction(abstractPlayer, RITE));
    }
}
