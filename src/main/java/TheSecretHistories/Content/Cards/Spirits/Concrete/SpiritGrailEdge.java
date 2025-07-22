package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Powers.UniqueCards.Spirit_GrailE_EdgePower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.actions.common.SuicideAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.beyond.*;
import com.megacrit.cardcrawl.monsters.city.*;
import com.megacrit.cardcrawl.monsters.ending.CorruptHeart;
import com.megacrit.cardcrawl.monsters.exordium.*;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.util.Objects;
import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritGrailEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritGrailEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_graile_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(GRAIL, 14),
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 6),
    };

    public SpiritGrailEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SuicideAction(m, false));

        addToBot(new SpawnMonsterAction(GetRandomMonster(m), false));
    }

    private AbstractMonster GetRandomMonster(AbstractMonster lastMonster) {

        float x = (lastMonster.drawX - Settings.WIDTH * 0.75F) / Settings.xScale;
        float y = (lastMonster.drawY - AbstractDungeon.floorY) / Settings.yScale;

        Random r = new Random();

        AbstractMonster monster;

        float f = new Random().nextFloat();

        if (f < 0.005f) {
            monster = new CorruptHeart();
        } else if (f < 0.2f) {
            AbstractMonster[] ms = new AbstractMonster[] {
                    new Spiker(x,y),
                    new Repulsor(x,y),
                    new Exploder(x,y),
                    new OrbWalker(x,y),
                    new Transient(),
                    new Nemesis(),
                    new Deca(),
                    new Donu(),
            };

            monster = ms[r.nextInt(ms.length)];
        } else if (f < 0.5f) {
            AbstractMonster[] ms = new AbstractMonster[] {
                    new SphericGuardian(x,y),
                    new Looter(x,y),
                    new Mugger(x,y),
                    new Byrd(x,y),
                    new Byrd(x,y),
                    new Byrd(x,y),
                    new SnakePlant(x,y),
                    new Taskmaster(x,y),
                    new SlaverRed(x,y),
                    new SlaverBlue(x,y),
                    new BronzeAutomaton(),
            };

            monster = ms[r.nextInt(ms.length)];
        } else {
            AbstractMonster[] ms = new AbstractMonster[] {
                    new Cultist(x,y),
                    new JawWorm(x,y),
                    new GremlinFat(x,y),
                    new GremlinWizard(x,y),
                    new GremlinNob(x,y),
                    new GremlinWarrior(x,y),
                    new GremlinThief(x,y),
                    new GremlinTsundere(x,y),
                    new TheGuardian(),
            };

            monster = ms[r.nextInt(ms.length)];
        }

        if (Objects.equals(monster.name, lastMonster.name)) {
            monster = GetRandomMonster(lastMonster);
        }

        if (this.upgraded) {
            float ratio = (float) lastMonster.currentHealth / lastMonster.maxHealth;
            monster.currentHealth = (int) (monster.maxHealth * ratio);
            monster.healthBarUpdatedEvent();
        }

        return monster;
    }

    public void OnUpgrade(int timesUpgraded) {

    }
}
