package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.Principles.SecretHistories;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.EndTurnAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritLanternSecret extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritLanternSecret.class.getSimpleName());
    private static final String IMG_NAME = "spirit_lanterne_secret";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final AbstractCard.CardTags PRINCIPLE_TAG = SECRET_HISTORIES;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(LANTERN, 15),
            new PrincipleUtils.ReducePrincipleInfo(SECRET_HISTORIES, 8),
    };

    public SpiritLanternSecret() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.baseMagicNumber = this.magicNumber = 24;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainPrincipleAction(p, PRINCIPLE_TAG, this.magicNumber));
        addToBot(new EndTurnAction());
    }

    @Override
    public void OnUpgrade(int timesUpgraded) {
        this.upgradeMagicNumber(6);
    }

}
