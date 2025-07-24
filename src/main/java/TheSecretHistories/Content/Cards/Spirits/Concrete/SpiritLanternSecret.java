package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Content.Powers.UniqueCards.LoseAllAlignmentNextTurnPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.EndTurnAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritLanternSecret extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritLanternSecret.class.getSimpleName());
    private static final String IMG_NAME = "spirit_lanterne_secret";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final AbstractCard.CardTags PRINCIPLE_TAG = SECRET_HISTORIES;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(LANTERN, 14),
            new PrincipleUtils.ReducePrincipleInfo(SECRET_HISTORIES, 6),
    };

    public SpiritLanternSecret() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.baseMagicNumber = this.magicNumber = 99;
        this.exhaust = true;
        this.isEthereal=true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Winter(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Edge(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Grail(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Lantern(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Moth(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Heart(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Knock(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Forge(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new SecretHistories(p, magicNumber), magicNumber));
        addToBot(new ApplyPowerAction(p, p, new LoseAllAlignmentNextTurnPower(p,magicNumber)));

    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        this.isEthereal=false;
    }

}
