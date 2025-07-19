package TheSecretHistories.Content.Cards.Others;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public class Favour extends TemplateCustomCard {

    public static final String ID = StringUtils.MakeID(Favour.class.getSimpleName());

    private static final String IMG_NAME = "favour";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;

    public Favour() {
        super(ID, IMG_NAME, COST, TYPE, COLOR, RARITY, TARGET);
        this.isEthereal = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isEthereal = false;
        this.retain = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
            (AbstractDungeon.getCurrRoom()).smoked = true;
            addToBot(new VFXAction(new SmokeBombEffect((abstractPlayer).hb.cX, (abstractPlayer).hb.cY)));
            AbstractDungeon.player.hideHealthBar();
            AbstractDungeon.player.isEscaping = true;
            AbstractDungeon.player.flipHorizontal = !AbstractDungeon.player.flipHorizontal;
            AbstractDungeon.overlayMenu.endTurnButton.disable();
            AbstractDungeon.player.escapeTimer = 2.5F;
        }
    }
}
